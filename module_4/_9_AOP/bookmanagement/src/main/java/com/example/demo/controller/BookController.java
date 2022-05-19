package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.entity.Contract;
import com.example.demo.exception.BookException;
import com.example.demo.service.BookService;
import com.example.demo.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("book")
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    ContractService contractService;

    @GetMapping("/list")
    public String getAllBook(
            @RequestParam(defaultValue = "") String key_name,
            @RequestParam(defaultValue = "") String key_category,
            @PageableDefault(size = 5) Pageable pageable,
            Model model) {
        Page<Book> books = bookService.getAllBook(key_name, key_category, pageable);
        model.addAttribute("books", books);
        return "/book/list" ;
    }

    @GetMapping("/view/{id}")
    public String viewBook(@PathVariable("id") Book book, Model model) {
        model.addAttribute("book", book);
        return "/book/view" ;
    }

    @GetMapping("/rent/{id}")
    public String takeBook(@PathVariable("id") Book book, Model model) {

        double randNumber = Math.random()*10000 +1;
        long id = (long)randNumber;

        Contract contract = new Contract();
        contract.setId(id);
        contract.setBook(book);
        contractService.save(contract);
// dùng if để xử lí lỗi.
        if(book.getQuantity() == 0) {
            model.addAttribute("message1", "Không thành công");
            model.addAttribute("message2", "Sách tạm hêt.");
            return "/book/result" ;
        }
        //giảm số lượng xuống 1.
        book.setQuantity(book.getQuantity()-1);
        bookService.save(book);

        model.addAttribute("message1", id);
        model.addAttribute("message2", "Mã số thuê sách của bạn là");
        return "/book/result" ;
    }

    @GetMapping("/viewBack")
    public String viewBackBook() {
        return "/book/viewBack" ;
    }


    @PostMapping("/giveBackBook")
    public String giveBackBook(@RequestParam("code") Long id, Model model) {

            Optional<Contract> contract = contractService.findById(id);
            List<Book> books = bookService.getAll();

            for (Book book : books) {
                if (book == contract.get().getBook()) {
                    //tăng só lượng lên 1
                    book.setQuantity(book.getQuantity() + 1);
                    // xóa hợp đồng mượn sách(xóa mã số).
                    contractService.delete(contract.get());
                    model.addAttribute("message1", "Đã trả sách thành công");
                    model.addAttribute("message2", "Đã trả sách thành công");
                    return "/book/result";
                }
            }
        model.addAttribute("message1", "Trả sách không thành công");
        model.addAttribute("message2", "Trả sách không thành công");
        return "/book/result";
    }

    @ExceptionHandler(BookException.class)
    public String errorHandler(BookException e, Model model) {
        model.addAttribute("message1", e.getMessage());
        model.addAttribute("message2", e.getMessage());
        System.err.println("=============Book controller============");
        return "redirect:/book/list";
    }
}

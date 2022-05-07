package codegym.controller;

import codegym.entity.Song;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import codegym.service.SongService;

import java.util.List;

@Controller
@RequestMapping
public class MusicController {
    @Autowired
    private SongService songService;


    @GetMapping()
    public String list(Model model) {
        List<Song> songs = songService.findAll();
        model.addAttribute("songs", songs);
        return "/song/list";
    }

    @GetMapping("/create")
    public String viewCreate(Model model) {
        model.addAttribute("song", new Song());
        model.addAttribute("link", "/create");
        return "/song/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("song") Song song) {
        songService.create(song);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id) {
        songService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String viewUpdate(@RequestParam("id") int id, Model model) {
        Song song = songService.findById(id);
        model.addAttribute("song", song);
        model.addAttribute("link", "/update");
        return "/song/create";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("song") Song song) {
       songService.update(song);
        return "redirect:/";
    }
}

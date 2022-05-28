function searchNameByAjax() {
    let key_author = $("#searchValue").val();
    $.ajax({
        url: "http://localhost:8080/api/blogs/search",
        data: {
            key_author: key_author
        },
        type: "get",
        dataType: "json",
        success: function (response) {
            console.log(response);
            let result = '';
            for (let i = 0; i < response.length; i++) {
                result += `
                    <tr>
                        <td scope="row" >${response[i].id}</td>
                        <td scope="row" >${response[i].title}</td>
                        <td scope="row" >${response[i].content}</td>
                        <td scope="row" >${response[i].author}</td>
                        <td scope="row" >${response[i].category.name}</td>
                        <td scope="row" ><a href="/blog/update/${response[i].id}" class="btn btn-primary">update</a></td>
                        <td scope="row" ><a onclick="infoDelete(${response[i].id})" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">Delete</a></td>
                    </tr>
                `;
            }
            // $("#result").html(result);
            $("#result").append(result);
        },
        error: function (e) {

        }
    });
}
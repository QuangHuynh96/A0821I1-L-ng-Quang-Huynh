function searchCustomerByAjax() {
    console.log("searchCustomerByAjax");
    $.ajax({
        url: "http://localhost:8080/api/customer/list",
        data: {
        },
        type: "get",
        dataType: "json",
        success: function (response) {
            console.log(response);
            let result = `
                <table className="table table-striped">
                    <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Customer type</th>
                        <th scope="col">Name</th>
                        <th scope="col">Birtday</th>
                        <th scope="col">Gender</th>
                        <th scope="col">ID card</th>
                        <th scope="col">Phone Number</th>
                        <th scope="col">Email</th>
                        <th scope="col">Address</th>
                        <th scope="col">Edit</th>
                        <th scope="col">Delete</th>
                    </tr>
                    </thead>
                <tbody>`;

            for (let i = 0; i < response.length; i++) {
                result += `
                    <tr th:each="item : ${customers}">
                        <th>${response[i].id}</th>
                        <td>${response[i].customerType.name}</td>
                        <td>${response[i].name}</td>
                        <td>${response[i].birtday}</td>
                        <td th:if="${item.gender}">Nam</td>
                        <td th:if="${!item.gender}">Nữ</td>
                        <td>${response[i].birtday}</td>
                        <td>${response[i].phone}</td>
                        <td>${response[i].email}</td>
                        <td>${response[i].address}</td>
                        <td scope="row" ><a href="/customer/update/${response[i].id}" class="btn btn-primary">update</a></td>
                        <td scope="row" ><a onclick="infoDelete(${response[i].id})" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">Delete</a></td>
                    </tr>
                `;
            }
            result += `
                        </tbody>
                    </table>`;
            $("#table-customer").html(result);
            // $("#result").append(result);
        },
        error: function (e) {

        }
    });
}
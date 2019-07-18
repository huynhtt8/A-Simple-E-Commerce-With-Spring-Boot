
function generate_table_cart() {
    cart = localStorage;
    var body = document.getElementById("cartItem");

    var tbl = document.getElementsByTagName("table")[0];
    var tblBody = document.createElement("tbody");


    for (var i = 0; i < cart.length; i++) {
        key = localStorage.key(i);
        item = JSON.parse(cart[key]);
        // creates a table row
        var row = document.createElement("tr");
        row.className += "cart" + item.productId;

        // var cell = document.createElement("td");
        // var cellText = document.createTextNode(i + 1);
        // cell.appendChild(cellText);
        // row.appendChild(cell);

        var cell = document.createElement("td");
        var cellText = document.createTextNode(item.productName);
        cell.appendChild(cellText);
        row.appendChild(cell);

        var cell = document.createElement("td");
        var cellText = document.createTextNode(item.quantity);
        cell.appendChild(cellText);
        row.appendChild(cell);

        var cell = document.createElement("td");
        var cellText = document.createTextNode(item.productPrice);
        cell.appendChild(cellText);
        row.appendChild(cell);

        var cell = document.createElement("td");
        var button = document.createElement("button");
        button.innerHTML = "Delete";
        button.className += "btn-primary";
        button.setAttribute( "onClick", "javascript: deleteProductFromCart(" +item.productId +");");
        cell.appendChild(button);
        row.appendChild(cell);
        tblBody.appendChild(row);
    }

    tbl.appendChild(tblBody);
}

function chageStatus(id) {
    var a = document.querySelector("#product-card-" + id);
    a.style.backgroundColor = 'green';
    a.innerHTML = "Added product";
    setTimeout(function () {
        a.style.backgroundColor = '#000';
        a.innerHTML = 'Add to Cart';
    },500);
}

function addProductToCart(id) {
    var key = 'cart' + id;

    if (localStorage.getItem(key) !== null) {
        cartItem = JSON.parse(localStorage.getItem(key));
        cartItem.quantity = cartItem.quantity + 1;
        localStorage.setItem(key ,JSON.stringify(cartItem));
        // console.log(cartItem);
    } else {
        cartItem={};
        $.ajax({
            type : "POST",
            contentType : "application/json",
            url : "api/add-product-to-cart",
            data : JSON.stringify(id),
            dataType : "json",
            cache : false,
            timeout : 600000,
            success : function (item) {

                cartItem.productId = item.productDTO.productId;
                cartItem.productName = item.productDTO.productName;
                cartItem.productPrice = item.productDTO.productPrice;
                cartItem.quantity = item.quantity;
                cartItem.image = item.productDTO.oneImage;
                localStorage.setItem(key ,JSON.stringify(cartItem));
                // console.log(cartItem);
            }
        });
    }
    chageStatus(id);
}


function deleteProductFromCart(id) {
    var key = 'cart' + id;
    if (localStorage.getItem(key) !== null) {
        localStorage.removeItem(key);
        document.querySelector(".cart"+id).remove();

    }

}

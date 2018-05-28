
function listBookings () {
    let xhttp = new XMLHttpRequest();
    xhttp.open("GET", "/booking/list?user=abc", false);  // TODO: false is synchronous
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.send();

    let obj = xhttp.responseText
    let json = JSON.parse (xhttp.responseText)
    let list = document.getElementById("list")

    if (typeof(list) !== 'undefined') {
        list.innerHTML = ""

        let table = document.createElement('table')
        table.id = "table1"
        let tr = document.createElement ('tr')
        let th1 = document.createElement ('th')
        let th2 = document.createElement ('th')
        let text1 = document.createTextNode("Date")
        let text2 = document.createTextNode("Note")
        th1.appendChild(text1)
        th2.appendChild(text2)
        tr.appendChild(th1)
        tr.appendChild(th2)
        table.appendChild (tr)
        for (let row_index in json) {
            let row = json[row_index]
            let tr = document.createElement ('tr')
            let td1 = document.createElement ('td')
            let td2 = document.createElement ('td')
            let text1 = document.createTextNode(row.date)
            let text2 = document.createTextNode(row.note)
            td1.appendChild(text1)
            td2.appendChild(text2)

            tr.appendChild(td1)
            tr.appendChild(td2)
            table.appendChild (tr)
        }
        list.appendChild(table);
    }
}


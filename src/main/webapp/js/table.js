var noneRecord=0, addRecord=1, deleteRecord=2, editRecord=3;
var finalRecord = 0;
var finalRecordList = [0,0,0];

function zipInJson(data){
    var rows = $('#orderTable tr');
    var records = [];
    for(var i=1;i<rows.length;i++){

        var row = rows[i];

        var expense = row.getElementsByTagName('TD')[0].innerHTML,
            description = row.getElementsByTagName('TD')[1].innerHTML,
            type = row.getElementsByTagName('TD')[2].innerHTML,
            date = row.getElementsByTagName('TD')[3].innerHTML;

        var eachElement = {
            expense: expense,
            description: description,
            type: type,
            date: date,
            pointer: finalRecordList[i-1]
        };

        records.push(eachElement);
    }

    var obj = {
        invoices:[
            {
                invoice_id:0,
                invoice_number:"",
                records: records,
                date:"Nov 12, 2015 3:28:17 PM",
                invoicer_address:"add",
                registration_number:0,
                VAT_number:0,
                email:"asd",
                client_address:"asd",
                client_name:"asd",
                client_email:"asd"
            }
        ]
    };
    console.log(JSON.stringify(obj));
}


$('#submitJson').click(function(){

    var jsonData={"name":"Hello World"};
    // JSON.stringify(jsonData);

    zipInJson(jsonData);

    $.ajax({
        url: '/kuan/Invoice',
        data: jsonData,
        type: "POST"
//        success: function (data) {
//            // console.log(data);
//            Window.location.href('localhost:8080/kuan/Invoice');
//        },
//        error: function(data) {
//            handleRequestError(data);
//        }
    }).done(function(){
        window.location.href="/kuan/Invoice";
    });
});

function addRow(){
    // if there is already an add button there.
    if(document.getElementById('tempRow') != null) return;
    document.getElementById("orderTable").innerHTML +=
        '<TR id="tempRow">' +
        '<TD>' +
        '<INPUT id="addId" class="inputGroup" TYPE="TEXT" NAME="EXPENSE">' +
        '</TD>' +
        '<TD>' +
        '<INPUT id="addDes" class="inputGroup" TYPE="TEXT" NAME="DES">' +
        '</TD>' +
        '<TD>' +
        '<SELECT id="addQua" class="editInput inputGroup">' +
        '<OPTION value="Rent">Rent</OPTION>' +
        '<OPTION value="Insurance">Insurance</OPTION>' +
        '<OPTION value="Taxes">Taxes</OPTION>' +
        '<OPTION value="Subscription Services">Subscription Services</OPTION>' +
        '<OPTION value="Childcare">Childcare</OPTION>' +
        '<OPTION value="Utilities">Utilities</OPTION>' +
        '</SELECT>' +
        '</TD>' +
        '<TD>' +
        '<INPUT id="addAmo" class="inputGroup" TYPE="DATE" NAME="DATE">' +
        '</TD>' +
        '<TD> <button class="push_button red" id="confirmAdd" type="button">Add</button>'+
        '<button class="confirmDelete push_button red" type="button">Delete</button> </TD>' +
        '</TR>';
    document.getElementById("confirmAdd").addEventListener("click", confirmAdd);
    $(".confirmDelete" ).click(function() {
        this.parentElement.parentElement.remove();
    });
}

function confirmAdd(){
    var expenseValue = document.getElementById("addId").value,
        desValue = document.getElementById("addDes").value,
        typeValue = document.getElementById("addQua").value,
        dateValue = document.getElementById("addAmo").value;

    document.getElementById("orderTable").innerHTML +=
        '<TR>' +
        '<TD>' + expenseValue + '</TD>' +
        '<TD>' + desValue + '</TD>' +
        '<TD>' + typeValue + '</TD>' +
        '<TD>' + dateValue + '</TD>' +
        '<td> <button class="confirmDelete push_button red" type="button">Delete</button> </td>'+
        '</TR>';

    $(".confirmDelete" ).click(function() {
        this.parentElement.parentElement.remove();
    });

    document.getElementById("tempRow").remove();

    finalRecord = addRecord
    finalRecordList.push(finalRecord);
}




$(".confirmDelete" ).click(function() {
    this.parentElement.parentElement.remove();
});


var editPointer = 0;

function editRow(){
    // Check if an edit operation is already in progress or if there's a temporary row
    if(editPointer == 1 || document.getElementById('tempRow') != null) return;

    // Retrieve all table rows
    var allTR = document.getElementsByTagName("TR");
    var previousRowsData = [];

    // Store previous rows' data for potential rollback
    for(var i = 1; i < allTR.length; i++){
        var previousRow = [];
        for(var u = 0; u < 4; u++){ // Assuming there are 4 columns in the table
            previousRow.push(allTR[i].getElementsByTagName('TD')[u].innerHTML);
        }
        previousRowsData.push(previousRow);
    }

    // Replace existing rows with input fields for editing
    for(var i = 1; i < allTR.length; i++){
        var element = allTR[i];
        element.innerHTML =
            '<TR class="tempRow">' +
            '<TD><INPUT class="editInput inputGroup" TYPE="TEXT" value="' + previousRowsData[i - 1][0] + '"></TD>' +
            '<TD><INPUT class="editInput inputGroup" TYPE="TEXT" value="' + previousRowsData[i - 1][1] + '"></TD>' +
            '<TD><INPUT class="editInput inputGroup" TYPE="TEXT" value="' + previousRowsData[i - 1][2] + '"></TD>' +
            '<TD><INPUT class="editInput inputGroup" TYPE="TEXT" value="' + previousRowsData[i - 1][3] + '"></TD>' +
            '</TR>';
    }

    // Add confirmation button for editing
    $('<button class="confirmEdit push_button blue" type="button">Confirm</button>').insertAfter('#editButton');

    // Attach event listener to the confirmation button
    $('.confirmEdit').click(function(){
        confirmEdit(previousRowsData);
    });

    // Set editPointer to indicate an edit operation is in progress
    editPointer = 1;
}

function confirmEdit(data){
    console.log(data);

    var expenseValue, desValue, typeValue,dateValue;

    for(var i=1; i<$('#orderTable TR').length;i++){

        expenseValue = $('#orderTable TR')[i].getElementsByTagName('TD')[0].getElementsByTagName('INPUT')[0].value;
        desValue = $('#orderTable TR')[i].getElementsByTagName('TD')[1].getElementsByTagName('INPUT')[0].value;
        typeValue = $('#orderTable TR')[i].getElementsByTagName('TD')[2].getElementsByTagName('INPUT')[0].value;
        dateValue = $('#orderTable TR')[i].getElementsByTagName('TD')[3].getElementsByTagName('INPUT')[0].value;


        for(var q=0;q<data[i-1].length;q++){
            var oneValue = $('#orderTable TR')[i].getElementsByTagName('TD')[q].getElementsByTagName('INPUT')[0].value;
            console.log(data[i-1][q], oneValue);
            if(oneValue != data[i-1][q]) finalRecordList[i-1] = editRecord;
        }

        $('#orderTable TR')[i].innerHTML='<TR>' +
            '<TD>' + expenseValue + '</TD>' +
            '<TD>' + desValue + '</TD>' +
            '<TD>' + typeValue + '</TD>' +
            '<TD>' + dateValue + '</TD>' +
            '<td> <button class="confirmDelete push_button red" type="button">Delete</button> </td>'+
            '</TR>';
    }



    $(".confirmDelete" ).click(function() {
        this.parentElement.parentElement.remove();
    });
    $('.confirmEdit').remove();
    editPointer = 0;
}
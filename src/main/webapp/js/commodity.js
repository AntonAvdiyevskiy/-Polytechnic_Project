window.onload = function () {

    load();
};


$('#save').click(function () {

    var commodity = {
        name: document.getElementById('nameCommodity').value,
        color: document.getElementById('colorOfCommodity').value,
        categoryOfCommodity: {
            id: document.getElementById('idCategory').value
        }

    };

    $.ajax({
        url: 'saveCommodity?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        contentType: 'application/json; charset=UTF-8',
        dataTypes: 'json',
        method: "POST",
        data: JSON.stringify(city),
        success : function () {
            load();
        }

    });
});

function load() {

    // document.getElementById('all').innerHTML = "";

    $.ajax({
        url: 'loadCommodity?' + $('input[name=csrf_name]').val() + "=" + $('input[name=csrf_value]').val(),
        contentType: 'application/json; charset=UTF-8',
        dataTypes: 'json',
        method: "POST",
        success : function (res) {

            var allCommodities = document.createElement('div');
            allCommodities.style.backgroundColor = 'aqua';
            allCommodities.style.border = 1+'px solid black';
            allCommodities.id = 'all';

            var all = '';

            for(var i = 0; i < res.length; i++){
                all += res[i].name + '<br>';
            }

            // allCities.innerHTML = all;

            // document.body.appendChild(allCities);

            document.getElementById('all').innerHTML = all;

        }

    });

};
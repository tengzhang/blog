$(function(){
    var $pageNo = 2,
        website = 'http://localhost:8080/';

    $(window).scroll(function() {
        if($(window).scrollTop() + $(window).height() == $(document).height()) {
            $('#show_more_container').show();
            $.getArchives($pageNo);
        }
    });

    $.getArchives = function(pageNo) {
        $.ajax({
            url: website + 'archive/ajax',
            type: 'get',
            data: {
                search: '',
                pageNo: pageNo
            },
            dataType: 'json',
            success: function(res) {
                if(res.success == 1) {
                    $('#show_more_container').hide();
                    $.showMore(res.data.list);
                    $pageNo ++;
                }
            }
        });
    }

    $.showMore = function(data) {
        var dataTmpl = '<div class="row">' +
                            '<div class="col-sm-12">' +
                                '<h3>' +
                                    '<i class="glyphicon glyphicon-hand-right"></i>' +
                                    '<a href= ' + website + '"archive/${id}">${title}</a>' +
                                    '<small> post on [${createTime]</small>' +
                                '</h3>' +
                            '</div>' +
                        '</div>';
        $.template('tmpl', dataTmpl);
        $.tmpl("tmpl", data).appendTo('#content');
    }
});
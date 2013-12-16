$(function() {
    getArchiveList('', 1);
});

function getArchiveList(search, pageNo) {
    $website = 'http://localhost:8080/blog/';

    $.ajax( {
        type: "get",
        url: $website + 'archive/ajax',
        data: {
            search: search,
            pageNo: pageNo
        },
        dataType: "json",
        success: function(res) {
            if(res.success == 1) {
                showRes(res.data.dataCount, res.data.list);
            }
        }
    });
}

function showRes(dataCount, list) {
    if(dataCount <= 0) {
        $('#nothing').show();
        return false;
    }

    var viewUrl = $website + 'archive/',
        updateUrl = $website + 'archive/update/',
        deleteUrl = $website + 'archive/delete/';

    $('#nothing').hide();
    var data = list,
        dataTmpl = '<tr>' +
            '<td class="center">' +
            '<label>'+
            '<input type="checkbox" class="ace" />' +
            '<span class="lbl"></span>' +
            '</label>' +
            '</td>' +
            '<td>' +
            '<a href="#">${title}</a>' +
            '</td>' +
            '<td>${createTimeStr}</td>' +
            '<td class="hidden-480"></td>' +
            '<td>${viewCount}</td>' +

            '<td class="hidden-480">' +
            '<span class="label label-sm label-warning">${status}</span>' +
            '</td>' +

            '<td>' +
            '<div class="visible-md visible-lg hidden-sm hidden-xs action-buttons">' +
            '<a class="blue" href="' + viewUrl + '${id}" target="_blank">' +
            '<i class="icon-zoom-in bigger-130"></i>' +
            '</a>' +

            '<a class="green" href="' + updateUrl +  '${id}" data-trigger="ajax" data-target="#ajax_target">' +
            '<i class="icon-pencil bigger-130"></i>' +
            '</a>' +

            '<a class="red" href="' + deleteUrl + '${id}" data-trigger="ajax" data-target="#ajax_target">' +
            '<i class="icon-trash bigger-130"></i>' +
            '</a>' +
            '</div>' +

            '<div class="visible-xs visible-sm hidden-md hidden-lg">' +
            '<div class="inline position-relative">' +
            '<button class="btn btn-minier btn-yellow dropdown-toggle" data-toggle="dropdown">' +
            '<i class="icon-caret-down icon-only bigger-120"></i>' +
            '</button>' +

            '<ul class="dropdown-menu dropdown-only-icon dropdown-yellow pull-right dropdown-caret dropdown-close">' +
            '<li>' +
            '<a href="'+ viewUrl +'${id}" class="tooltip-info" data-rel="tooltip" title="View" data-trigger="ajax" data-target="#ajax_target">' +
            '<span class="blue">' +
            '<i class="icon-zoom-in bigger-120"></i>' +
            '</span>' +
            '</a>' +
            '</li>' +

            '<li>' +
            '<a href="' + updateUrl + '${id}" class="tooltip-success" data-rel="tooltip" title="Edit" data-trigger="ajax" data-target="#ajax_target">' +
            '<span class="green">' +
            '<i class="icon-edit bigger-120"></i>' +
            '</span>' +
            '</a>' +
            '</li>' +

            '<li>' +
            '<a href="' + deleteUrl + '${id}" class="tooltip-error" data-rel="tooltip" title="Delete" data-trigger="ajax" data-target="#ajax_target">' +
            '<span class="red">' +
            '<i class="icon-trash bigger-120"></i>' +
            '</span>' +
            '</a>' +
            '</li>' +
            '</ul>' +
            '</div>' +
            '</div>' +
            '</td>' +
            '</tr>';

    $.template("dataTemplate", dataTmpl);
    $.tmpl("dataTemplate", data).appendTo("#archive-tbody");
}
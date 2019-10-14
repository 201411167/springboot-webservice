var updateModal={
    currentId : 0,
    currentContent : '',
    init : function(){
        console.log('updateModal.js');
    },
    getId : function(id){
        currentId = id;
        console.log(currentId);
    },
    updateContent : function(content){
        currentContent = content;
        var dataSet = {
            id : currentId,
            content : currentContent
        };
        console.log(dataSet);

        $.ajax({
            type: 'POST',
            url: '/updatePosts',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(dataSet)
        }).done(function(){
            console.log('done');
            alert('글이 수정되었습니다');
            location.reload();
        }).fail(function(error){
            console.log(error);
        })
    }
};

updateModal.init();
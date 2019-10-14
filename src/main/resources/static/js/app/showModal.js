var showModal = {
    init : function(){
        console.log('showModal.js');
    },
    showPosts : function(content){
        console.log(content);
        $('#showPostsModal').on('show.bs.modal',function(event){
            $('.modal-body #contentView').val(content);
        })
    }
};
showModal.init();
$(function(){

	var fn_main = {
		init: function(){
			fn_log.init();
			fn_modal.newUser();
		}
	};

	var fn_log = {
		init: function(){
			console.log($);
		}
	};

	var fn_modal = {
		newUser: function(){
			$('#new-user').on('click', function(){
				$('#modal-new-user').modal('show');
			});
		}
	};

	fn_main.init();

});
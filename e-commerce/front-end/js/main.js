$(function(){

	var fn_main = {
		init: function(){
			fn_log.init();
		}
	};

	var fn_log = {
		init: function(){
			console.log($);
		}
	};

	fn_main.init();

});
window.onload=function(){
	var register_button=$("#register_button");
	var register_data=$("#register").serialize();
	register_button.click(function(){
		register_ajax();
	})
}
function register_ajax(){
	 $.post("demo_ajax_gethint.asp",register_data,function(result){
		   if(result=""){}
     });
}
 

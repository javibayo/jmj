$(function() {
     // Handler for .ready() called.
     setWindowHeight();
     initLinks();
});

/*functions on startu*/

var setWindowHeight = function (){
	var a=window.innerHeight;
	console.log(a);
	/*$(".body_content").css('height',a);*/
}

var initLinks = function(){
	$('.menu_container ul li a').each(function() {
		var html=$(this).attr('id');
		console.log('#menu_'+html+'_content');
		var selectedDiv = $('#menu_'+html+'_content');
		if(selectedDiv.hasClass('menu_showed')){
			$.get('./templates/tmpl.'+html+'.html', function(template) {
				selectedDiv.html(template);
			});
		}

	      $(this).click(function() {
	        var html=$(this).attr('id');
	        console.log('#menu_'+html+'_content');
			var selectedDiv = $('#menu_'+html+'_content');
			if(selectedDiv.html()==''){
				$.get('./templates/tmpl.'+html+'.html?'+Math.random(), function(template) {
				
					selectedDiv.html(template);
						  
				});
			}
			$('.menu_showed').removeClass('menu_showed');
			selectedDiv.addClass('menu_showed');
	        
	        return false;
	      });
    });

}
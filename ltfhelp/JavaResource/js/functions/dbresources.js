var dbResourcesVisible = false;
function toggleDbResources(){
	dbResourcesVisible = !dbResourcesVisible;
	var el = document.getElementById('forcopy');
	if(dbResourcesVisible){
		el.style.display = 'block';
	}else{
		el.style.display = 'none';
	}
	
}

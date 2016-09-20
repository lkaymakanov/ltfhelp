



function sortByUserId(a,b){
  if (a.userid < b.userid)
    return -1;
  if (a.userid > b.userid)
    return 1;
  return 0;
};

function sortByUserName(a,b){
  if (a.username < b.username)
    return -1;
  if (a.username > b.username)
    return 1;
  return 0;
};


function sortByMunicipalityName(a,b){
  if (a.municipalityname < b.municipalityname)
    return -1;
  if (a.municipalityname > b.municipalityname)
    return 1;
  return 0;
};

function createTableRow(ltfuser, index){
    var cls = ( index%2 == 0) ? 'even': 'odd';
	return '<tr class="' + cls +'">' + '<td>' + ltfuser.userid + '</td>' +  
	  '<td>' + ltfuser.username +   
	  '</td>' + '<td>' +ltfuser.municipalityname +  '</td>' + '</tr>'; 
}

function recreateTable(sortfunction){
	var d = document.getElementById('tableDiv');
	var tableStr='<table class="register">';
	var header='<tr class="header">' + '<td>' + '<a href="#" onclick="recreateTable(sortByUserId);" > UserId</a>' +  
	'</td>' +  '<td>' + '<a href="#" onclick="recreateTable(sortByUserName);" > UserName</a>' + 
	'</td>' +  '<td>' + '<a href="#" onclick="recreateTable(sortByMunicipalityName);" > Municipality</a>' + '</td>' +  '</tr>';
	tableStr+=header;
	ltfusers.sort(sortfunction);
	for(i=0; i < ltfusers.length; i++){tableStr+=(createTableRow(ltfusers[i],i));}
	tableStr+='</table>';
	d.innerHTML = tableStr;
}
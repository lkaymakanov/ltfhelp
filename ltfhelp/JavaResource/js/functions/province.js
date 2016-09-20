function sortByProvinceId(a,b){
  if (a.provinceid < b.provinceid)
    return -1;
  if (a.provinceid > b.provinceid)
    return 1;
  return 0;
};

function sortByEkkate(a,b){
  if (a.ekkate < b.ekkate)
    return -1;
  if (a.ekkate > b.ekkate)
    return 1;
  return 0;
};

function sortByName(a,b){
  if (a.name < b.name)
    return -1;
  if (a.name > b.name)
    return 1;
  return 0;
};

function sortByCode(a,b){
  if (a.code < b.code)
    return -1;
  if (a.code > b.code)
    return 1;
  return 0;
};


function createTableRow(province, index){
	var cls = ( index%2 == 0) ? 'even': 'odd';
	return '<tr class="' + cls +'">' +
	'<td>' + province.provinceid + '</td>' +  '<td>' + province.ekkate +   '</td>' + '<td>' +province.name +  '</td>' + '<td>' +province.code +  '</td>' + '</tr>'; 
}

function recreateTable(sortfunction){
	var d = document.getElementById('tableDiv');
	var tableStr='<table class="register">';
	var header='<tr class="header">' + '<td>' + '<a href="#" onclick="recreateTable(sortByProvinceId);" > ProvinceId</a>' +  '</td>' + 
	'<td>' + '<a href="#" onclick="recreateTable(sortByEkkate);" > Ekkate</a>' + '</td>' +  
	'<td>' + '<a href="#" onclick="recreateTable(sortByName);" >Name</a>' + '</td>' +  
	'<td>' + '<a href="#" onclick="recreateTable(sortByCode);" >Code</a>' + '</td>'	+ 
	'</tr>';
	tableStr+=header;
	provinces.sort(sortfunction);
	for(i=0; i < provinces.length; i++){tableStr+=(createTableRow(provinces[i], i));}
	tableStr+='</table>';
	d.innerHTML = tableStr;
}

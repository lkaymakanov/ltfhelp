
function sortByMuniciaplityId(a,b){
  if (a.municipalityId < b.municipalityId)
    return -1;
  if (a.municipalityId > b.municipalityId)
    return 1;
  return 0;
};

function sortByFullName(a,b){
  if (a.fullname < b.fullname)
    return -1;
  if (a.fullname > b.fullname)
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

function sortByEbkCode(a,b){
  if (a.ebkcode < b.ebkcode)
    return -1;
  if (a.ebkcode > b.ebkcode)
    return 1;
  return 0;
};

function sortByEkatte(a,b){
  if (a.ekatte < b.ekatte)
    return -1;
  if (a.ekatte > b.ekatte)
    return 1;
  return 0;
};


function createTableRow(municipality, index){
	var cls = ( index%2 == 0) ? 'even': 'odd';
	return '<tr class="' + cls +'">' +
	'<td>' + municipality.municipalityId + '</td>' +  '<td>' + municipality.fullname +   '</td>' + '<td>' +municipality.name +  '</td>' + '<td>' +municipality.code +  '</td>' + 
	'<td>' +municipality.ebkcode +  '</td>' +
	'<td>' +municipality.ekatte +  '</td>' +
	'<td>' +municipality.oldcode +  '</td>' +
	'</tr>'; 
}

function recreateTable(sortfunction){
	var d = document.getElementById('tableDiv');
	var tableStr='<table class="register">';
	var header='<tr class="header">' + 
	'<td>' + '<a href="#" onclick="recreateTable(sortByMuniciaplityId);" > MunicipalityId</a>' +  '</td>' +  
	'<td>' + '<a href="#" onclick="recreateTable(sortByFullName);" > FullName</a>' +  '</td>' +  
	'<td>' + '<a href="#" onclick="recreateTable(sortByName);" > Name</a>' +  '</td>' +  
	'<td>' + '<a href="#" onclick="recreateTable(sortByCode);" > Code</a>' +  '</td>' +  
	'<td>' + '<a href="#" onclick="recreateTable(sortByEbkCode);" > EbkCode</a>' +  '</td>' +  
	'<td>' + '<a href="#" onclick="recreateTable(sortByEkatte);" > Ekatte</a>' +  '</td>' +  
	'<td>' + 'OldCode' + '</td>' + 
	'</tr>';
	tableStr+=header;
	municipalities.sort(sortfunction);
	for(i=0; i < municipalities.length; i++){tableStr+=(createTableRow(municipalities[i], i));}
	tableStr+='</table>';
	d.innerHTML = tableStr;
}
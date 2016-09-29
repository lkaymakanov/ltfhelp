function sortByCountryId(a,b){
  if (a.countryid < b.countryid)
    return -1;
  if (a.countryid > b.countryid)
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



function createTableRow(country, index){
	var cls = ( index%2 == 0) ? 'even': 'odd';
	return '<tr class="' + cls +'">' +
	'<td>'+ country.countryid + '</td>' +  '<td>' + country.name +   '</td>' + '<td>' +country.code +  '</td>' + '<td>' +country.shortname +  '</td>' + '</tr>'; 
}

function recreateTable(sortfunction){
	var d = document.getElementById('tableDiv');
	var tableStr='<table class="register">';
	var header='<tr class="header">' + '<td>' + '<a href="#" onclick="recreateTable(sortByCountryId);" > CountryId</a>' + 
	'</td>' +  '<td>' + '<a href="#" onclick="recreateTable(sortByName);" > Name</a>' + '</td>' +   
	'<td>' + '<a href="#" onclick="recreateTable(sortByCode);"> Code</a>' + '</td>' + 
    '<td>' + 'ShortName' + '</td>' + 	'</tr>';
	tableStr+=header;
	countries.sort(sortfunction);
	for(i=0; i < countries.length; i++){tableStr+=(createTableRow(countries[i],i));}
	tableStr+='</table>';
	d.innerHTML = tableStr;
}
function sortByCityId(a,b){
  if (a.cityid < b.cityid)
    return -1;
  if (a.cityid > b.cityid)
    return 1;
  return 0;
};

function sortByMunicipalityId(a,b){
  if (a.municipalityid < b.municipalityid)
    return -1;
  if (a.municipalityid > b.municipalityid)
    return 1;
  return 0;
};


function sortByKindCity(a,b){
  if (a.kind_city < b.kind_city)
    return -1;
  if (a.kind_city > b.kind_city)
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

function sortByEkkate(a,b){
  if (a.ekkate < b.ekkate)
    return -1;
  if (a.ekkate > b.ekkate)
    return 1;
  return 0;
};


function sortByPostCode(a,b){
  if (a.postcode < b.postcode)
    return -1;
  if (a.postcode > b.postcode)
    return 1;
  return 0;
};

function sortByCategory(a,b){
  if (a.category < b.category)
    return -1;
  if (a.category > b.category)
    return 1;
  return 0;
};


function createTableRow(city, index){
	var cls = ( index%2 == 0) ? 'even': 'odd';
	return '<tr class="' + cls +'">' +
	'<td>' + city.cityid + '</td>' + 
  	'<td>' + city.municipalityid +   '</td>' + 
	'<td>' +city.kind_city +  '</td>' + 
	'<td>' +city.name +  '</td>' + 
	'<td>' +city.ekkate +  '</td>' + 
	'<td>' +city.postcode +  '</td>' + 
	'<td>' +city.category +  '</td>' + 
	'</tr>'; 
}

function recreateTable(sortfunction){
	var d = document.getElementById('tableDiv');
	var tableStr='<table class="register" >';
	var header='<tr class="header">' + '<td>' + '<a href="#" onclick="recreateTable(sortByCityId);" > CityId</a>' + 
	'</td>' +  '<td>' + '<a href="#" onclick="recreateTable(sortByMunicipalityId);" > MuniciaplityId</a>' + '</td>' +  
	'</td>' +  '<td>' + '<a href="#" onclick="recreateTable(sortByKindCity);" > KindCity</a>' + '</td>' +  
	'</td>' +  '<td>' + '<a href="#" onclick="recreateTable(sortByName);" > Name</a>' + '</td>' +  
	'</td>' +  '<td>' + '<a href="#" onclick="recreateTable(sortByEkkate);" > Ekkatte</a>' + '</td>' +  
	'</td>' +  '<td>' + '<a href="#" onclick="recreateTable(sortByPostCode);" > PostCode</a>' + '</td>' +  
	'</td>' +  '<td>' + '<a href="#" onclick="recreateTable(sortByCategory);" > Category</a>' + '</td>' +  
	
	'</tr>';
	tableStr+=header;
	cities.sort(sortfunction);
	for(i=0; i < cities.length; i++){tableStr+=(createTableRow(cities[i], i));}
	tableStr+='</table>';
	d.innerHTML = tableStr;
}
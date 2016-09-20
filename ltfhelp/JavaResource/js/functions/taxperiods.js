function sortByTaxperiodId(a,b){
  if (a.taxperiod_id < b.taxperiod_id)
    return -1;
  if (a.taxperiod_id > b.taxperiod_id)
    return 1;
  return 0;
};

function sortBybeginDate(a,b){
  if (a.begin_date < b.begin_date)
    return -1;
  if (a.begin_date > b.begin_date)
    return 1;
  return 0;
};


function createTableRow(taxperiod, index){
	var cls = ( index%2 == 0) ? 'even': 'odd';
	return '<tr class="' + cls +'">' +
	'<td>' + taxperiod.taxperiod_id + '</td>' +  '<td>' + taxperiod.begin_date +   '</td>' + '<td>' +taxperiod.end_date +  '</td>' + '<td>' +taxperiod.taxperiod_kind +  '</td>' + '</tr>'; 
}

function recreateTable(sortfunction){
	var d = document.getElementById('tableDiv');
	var tableStr='<table class="register">';
	var header='<tr class="header">' + '<td>' + '<a href="#" onclick="recreateTable(sortByTaxperiodId);" > TaxperiodId</a>' +  '</td>' +  '<td>' + '<a href="#" onclick="recreateTable(sortBybeginDate);" > BeginDate</a>' + '</td>' +  '<td>' + 'EndDate' + '</td>' +  '<td>' + 'Kind' + '</td>' +  '</tr>';
	tableStr+=header;
	taxperiods.sort(sortfunction);
	for(i=0; i < taxperiods.length; i++){tableStr+=(createTableRow(taxperiods[i], i));}
	tableStr+='</table>';
	d.innerHTML = tableStr;
}
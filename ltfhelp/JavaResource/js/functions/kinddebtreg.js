var sortfunctions = {
kinddebtregid:

function sortByKindDebtRegId(a,b){
  if (a.kinddebtregid < b.kinddebtregid)
    return -1;
  if (a.kinddebtregid > b.kinddebtregid)
    return 1;
  return 0;
},
code:
function sortByCode(a,b){
  if (a.code < b.code)
    return -1;
  if (a.code > b.code)
    return 1;
  return 0;
},
fullname:
function sortByFullName(a,b){
  if (a.fullname < b.fullname)
    return -1;
  if (a.fullname > b.fullname)
    return 1;
  return 0;
};
name:
function sortByName(a,b){
  if (a.name < b.name)  return -1; 
  if (a.name > b.name)  return 1;  
  return 0;
}

};



function createTableRow(kinddebtreg, index){
	var cls = ( index%2 == 0) ? 'even': 'odd';
	return '<tr class="' + cls +'">' +
	'<td>' + kinddebtreg.kinddebtregid + '</td>' +  '<td>' + kinddebtreg.code +   '</td>' + '<td>' +kinddebtreg.fullname +  '</td>' + '<td>' +kinddebtreg.name +  '</td>' + '<td>' +kinddebtreg.acc +  '</td>' + '</tr>'; 
}

function recreateTable(sortfunction){
	var d = document.getElementById('tableDiv');
	var tableStr='<table class="register">';
	var header='<tr class="header">' + '<td>' + '<a href="#" onclick="recreateTable(sortByKindDebtRegId);" > KinddebtregId</a>' +  
	'</td>' +  '<td>' + '<a href="#" onclick="recreateTable(sortByCode);" > Code</a>' + '</td>' + 
	'<td>' + '<a href="#" onclick="recreateTable(sortByFullName);" > FullName <a/>' + '</td>' +  '<td>' + '<a href="#" onclick="recreateTable(sortByName);" >Name</a>' + '</td>' + '<td>' + 'Acc' + '</td>' +   '</tr>';
	tableStr+=header;
	kinddebtregs.sort(sortfunction);
	for(i=0; i < kinddebtregs.length; i++){tableStr+=(createTableRow(kinddebtregs[i],i));}
	tableStr+='</table>';
	d.innerHTML = tableStr;
}
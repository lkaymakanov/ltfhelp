function escapeRegExp(str) {
    return str.replace(/([.*+?^=!:${}()|\[\]\/\\])/g, "\\$1");
}

function replaceAll(str, find, replace) {
  return str.replace(new RegExp(escapeRegExp(find), 'g'), replace);
}


function createOpt(opts){
	var opt ='';
	var i = 0;
	if(opts == null || opts.length == 0) return '';
	console.log(opts);
	var ll = opts.length;
	for(i=0; i < opts.length; i++){
	   opt+=('<option>' +	(opts[i]) +'</option>' );
	   console.log(opt);
	}
	opt =  '<select>' + opt + '</select>';
	return opt;
}

function highlightText(text){
	var bh = document.getElementById("highlight").checked;
	if(!bh) return text;
	var highlighetdText = '<span class="highlight">' + document.getElementById("searchtext").value + '</span>';
	var textTohiglight = document.getElementById("searchtext").value;
	return replaceAll(text, textTohiglight, highlighetdText);
}


function createTableRow(tcols, index){
	var cls = ( index%2 == 0) ? 'even': 'odd';
	return '<tr class="' + cls +'">' +
	'<td>' + highlightText(tcols.tablename) + '</td>' + 
	'<td>' + highlightText(tcols.columnname) + '</td>' + 
	'<td>' + tcols.columntype + '</td>' + 
	'<td>' + tcols.nullable + '</td>' + 
	'<td>' + tcols.maxcharlength + '</td>' + 
	'<td>' + replaceAll(tcols.comment, '@@', '<br/>') + '' + createOpt(tcols.opts) + '</td>' + 
	'</tr>'; 
}


function filterColumn(tc){
	var inputSearch = document.getElementById("searchtext").value;
	if(inputSearch.length < 3) return false;
	var bSearchCols = document.getElementById("ckSearchInColumns").checked;
	var bSearchTables = document.getElementById("ckSearchInTables").checked;
	var bDirectMatch = document.getElementById("ckDirectMatch").checked;

	inputSearch = inputSearch.toLowerCase();
	
	if(bSearchCols) bSearchCols =  bDirectMatch ? tc.columnname == inputSearch  : tc.columnname.indexOf(inputSearch) > -1;
	if(bSearchTables ) bSearchTables = bDirectMatch  ? tc.tablename == inputSearch  : tc.tablename.indexOf(inputSearch) > -1
	
	return bSearchCols || bSearchTables;
};

//show filtered content
function showFiltered(filtered){
	var d = document.getElementById('filtered');
	var tableStr='<table class="register">';
	var headr = '<tr class="header">' +
	'<td>tableName</td>' + 
	'<td>columNname</td>' + 
	'<td>columnType</td>' + 
	'<td>isNullable</td>' + 
	'<td>maxCharLength</td>' + 
	'<td>comment</td>' + 
	'</tr>'; 
	tableStr+=headr;
	if(filtered.length == 0) {d.innerHTML = ''; return;}
	for(i=0; i < filtered.length; i++){tableStr+=(createTableRow(filtered[i], i));}
	tableStr+='</table>';
	d.innerHTML = tableStr;
};

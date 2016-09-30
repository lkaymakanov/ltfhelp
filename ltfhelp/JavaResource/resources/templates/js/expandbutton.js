/**
 * A simple expand collapse button class
 */
function ExpandButton(){
	this.openImg = 'css/folder_open.png';
	this.closeImg = 'css/folder.png';
	this.height=32;         //the height of the button in pixels
	this.width=32;		    //the width of the button in pixels
	this.expand = 'false';    //expanded or not
	this.oncolapse  = function(el){};
	this.onexpand = function(el){};
	
	this.toggle = function(el){
		var state = el.dataset.expand;
		if(state=='true'){
			el.dataset.expand = 'false';
			el.innerHTML = '<img style="width:' + this.width + 'px; height:' + this.height + 'px;" src="'+ this.closeImg + '"></img>';
			if(this.oncolapse != null )this.oncolapse(el);
		}else{
			el.dataset.expand='true';
			el.innerHTML = '<img style="width:' + this.width + 'px; height:' + this.height + 'px;" src="'+ this.openImg + '"></img>';
			if(this.onexpand !=null )this.onexpand(el);
		}
	};
};

//argument constructor
ExpandButton.prototype.init_1 = function (openImg, closeImg, height, width, expand, onexpand, oncolapse){
    this.openImg = openImg;
	this.closeImg = closeImg;
	this.height=height;       //the height of the button in pixels
	this.width=width;		   //the width of the button in pixels
	this.expand = 'expand';
	this.oncolapse = eval(oncolapse);
	this.onexpand = eval(onexpand);
    return this;
};

//shows or hides element by id
function showelement(elId, show){
	var el = document.getElementById(elId);
	if(show) el.style.display='block';
	else el.style.display='none';
}


//a function that creates the expand/collapse button
function createExpandButton(openImg, closeImg, height, width, expand, onexpand, oncolapse){
    var expression = 'new ExpandButton().init_1(\''+ openImg + '\',' +  '\'' +closeImg +  '\''  + ',' + height+ ',' + width + ',' +expand +  ',' +onexpand + ',' +oncolapse +  ')';
	var btn = '<span  data-expand="' + expand + '" data-buttondata="'+ expression+'" ' + ' onclick="eval(this.dataset.buttondata).toggle(this);" >';
	if(expand == 'true')
	    btn+=' <img style="width:' + width + 'px; height:' + height + 'px;" src="'+ openImg + '"></img>';
	else {
		btn+=' <img style="width:' + width + 'px; height:' + height + 'px;" src="'+ closeImg + '"></img>';
	}
	btn+='</span>';
	document.write(btn);
};

/***
 example
 
<script>
	createExpandButton('css/folder_open.png', 'css/folder.png', 20, 20, 'true', 'function(el){console.log(\'expand\');}' , 'function(el){console.log(\'collapse\');}');
</script>

 
 */

var selectedLinkId="-1";
var highlightColor = 'brown';
var selectColor = "red";
var testOffset = 31;
//

var links = [ 
{protocol:"http", ip:"172.22.62.105", port:"", context:"LTF", name:"SOFIA - req.VPN" },
{protocol:"http", ip:"10.0.10.106", port:"8080", context:"LTF", name:"PLOVDIV" }, 
{protocol:"http", ip:"10.0.10.140", port:"8080", context:"LTF", name:"KALOQNOVO"},
{protocol:"http", ip:"10.0.10.131", port:"8080", context:"LTF", name:"KARLOVO"},
{protocol:"http", ip:"10.0.10.150", port:"8080", context:"LTF", name:"SOPOT"},
{protocol:"http", ip:"10.0.10.130", port:"8080", context:"LTF", name:"RODOPI"},
{protocol:"http", ip:"10.0.10.132", port:"", context:"LTF", name:"BREZOVO"},
{protocol:"http", ip:"10.0.10.133", port:"8080", context:"LTF", name:"SAEDINENIE"},
{protocol:"http", ip:"10.241.110.75", port:"8080", context:"LTF", name:"PARVOMAI"},
{protocol:"http", ip:"10.0.10.197", port:"8080", context:"LTF", name:"RAKOVSKI"},
{protocol:"http", ip:"10.0.10.127", port:"8080", context:"LTF", name:"BOTEVGRAD"},
{protocol:"http", ip:"10.0.10.108", port:"8080", context:"LTF", name:"SADOVO"},
{protocol:"http", ip:"10.0.10.68", port:"8080", context:"LTF", name:"RAZLOG"},
{protocol:"https", ip:"10.0.10.52", port:"8443", context:"LTF", name:"RAZGRAD"},
{protocol:"http", ip:"10.0.10.27", port:"8080", context:"LTF", name:"MARICA"},
{protocol:"http", ip:"10.0.10.51", port:"8080", context:"LTF", name:"STRUMQNI"},
{protocol:"http", ip:"10.0.10.158", port:"8080", context:"LTF", name:"KUKLEN"},
{protocol:"http", ip:"10.0.10.154", port:"8080", context:"LTF", name:"POMORIE"},
{protocol:"http", ip:"10.20.62.12", port:"", context:"LTF", name:"PERNIK"},
{protocol:"http", ip:"10.0.10.190", port:"8080", context:"LTF", name:"STAMBOLIISKI"},
{protocol:"http", ip:"10.0.10.120", port:"8080", context:"LTF", name:"KOSTINBROD"},
{protocol:"http", ip:"10.0.10.170", port:"8080", context:"LTF", name:"PERUSHTITSA"},
{protocol:"http", ip:"app.uni-sz.bg", port:"80", context:"iuis", name:"IUIS"},
{protocol:"http", ip:"10.0.10.143", port:"8080", context:"LTF", name:"ASENOVGRAD"},
{protocol:"http", ip:"10.0.10.100", port:"8080", context:"LTF", name:"BRACIGOVO"},
{protocol:"http", ip:"10.240.44.183", port:"", context:"LTF", name:"TEST_SOFIQ-183"},
{protocol:"http", ip:"10.40.19.25", port:"", context:"LTF", name:"TEST_SOFIQ-25"},
{protocol:"http", ip:"10.240.110.70", port:"8080", context:"LTF", name:"TEST_PLOVDIV"},
{protocol:"https", ip:"10.0.10.25", port:"8443", context:"LTF", name:"PRAVETS"},
{protocol:"https", ip:"10.0.10.43", port:"8443", context:"LTF", name:"RILA"},
{protocol:"https", ip:"10.0.10.148", port:"8443", context:"LTF", name:"KRICHIM"},
{protocol:"https", ip:"10.0.10.147", port:"8443", context:"LTF", name:"LUKI"},
{protocol:"https", ip:"10.240.63.241", port:"", context:"LTF", name:"VARNA"},
{protocol:"https", ip:"10.244.78.1", port:"6565", context:"LTF", name:"BURGAS"}
];
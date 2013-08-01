/*var intervalID;  
            function changeColor(){  
                intervalID = setInterval(flashText, 3000);  
            }  
            function flashText(){
               var elem = document.getElementById("map");  
               elem.setAttribute("model","#{mapBean.advancedModel}");
             //   $('#labell').attr('value','#{mapBean.ejemplo}');
            }  
*/
var currentMarker = null;  
var i = "asd";    
function handleComplete(xhr, status, args){
   var gmap = mapa.getMap();
   for(var i in gmap.markers)
   {
    //  var newMarker = eval("args.marker"+i);
      var lat = eval("args.lat"+i);
      var lng = eval("args.lng"+i);
      var oldMarker = gmap.markers[i];
     // oldMarker.icon = newMarker.icon;
      oldMarker.position = new google.maps.LatLng(lat,lng);
      oldMarker.setAnimation(google.maps.Animation.BOUNCE);
      oldMarker.setMap(gmap);                      
   }   
}
    function handlePointClick(){  
                //intervalID = setInterval(handle, 3000);  
                       
    }  
    function handle() {  
        if(i === "asd"){
            //currentMarker.setMap(null);
            currentMarker = new google.maps.Marker({  
                position:new google.maps.LatLng(-33.4372,-70.6506)                
            });  
            currentMarker.setAnimation(google.maps.Animation.BOUNCE);
            
            google.maps.visualRefresh = true;
            mapa.addOverlay(currentMarker);
            
        }else{
            //currentMarker.setMap(null);
            currentMarker = new google.maps.Marker({  
                position:new google.maps.LatLng(-32.4372,-70.6506)                
            });  
            currentMarker.setAnimation(google.maps.Animation.BOUNCE);
            google.maps.visualRefresh = true;
            mapa.addOverlay(currentMarker);
            i = "asd";
        }
        
    }  
  
    function markerAddComplete() {  
        var title = document.getElementById('title');  
        currentMarker.setTitle(title.value);  
        title.value = "";  
  
        currentMarker = null;  
        dlg.hide();  
    }  
  
    function cancel() {  
        dlg.hide();  
        currentMarker.setMap(null);  
        currentMarker = null;  
  
        return false;  
    } 
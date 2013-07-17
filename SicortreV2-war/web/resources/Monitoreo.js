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
      
    function handlePointClick(event) {   
        if(currentMarker === null) {  
            currentMarker = new google.maps.Marker({  
                position:new google.maps.LatLng(-33.4372,-70.6506)  
            });  
                              
            mapa.addOverlay(currentMarker);  
            
             
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
var map;
var panel;
var initialize;
var calculate;
var direction;

var lat;
var long;

var details = "";
function initMap() {
    map = new google.maps.Map(document.getElementById('map'), {
        center: {lat: 50.6075138, lng: 3.1546705},
        zoom: 13
    });


    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(showPosition);
    } else {
        document.getElementById("position").innerHTML = "La geolocation n'est pas supportée par votre navigateur.";
    }
    ;


    function showPosition(position) {
        lat = (position.coords.latitude);

        var marker = new google.maps.Marker({
            position: {lat: position.coords.latitude, lng: position.coords.longitude},
            map: map,
            title: 'moi',
            icon: 'Images/House.png'
        });
        var infowindow = new google.maps.InfoWindow({
            content: "Ma position!"
        });
        marker.addListener('mouseover', function () {
            infowindow.open(map, marker);
        });
    }

    // alert(navigator.geolocation.getCurrentPosition(show));


    direction = new google.maps.DirectionsRenderer({
        map: map,
        panel: document.getElementById('panel')
    });

}

calculate = function () {
    origin = document.getElementById('origin').value; // Le point départ
    destination = document.getElementById('destination').value; // Le point d'arrivé



    if (origin && destination) {
    var request = {
    origin: origin,
            destination: destination,
            travelMode: google.maps.TravelMode.DRIVING,
            drivingOptions: {
            departureTime: new Date(Date.now()), 
                    trafficModel: "optimistic"
            },
            unitSystem: google.maps.UnitSystem.METRIC
        };
        
    var directionsService = new google.maps.DirectionsService(); // Service de calcul d'itinéraire
            directionsService.route(request, function (response, status) { // Envoie de la requête pour calculer le parcours
                if (status == google.maps.DirectionsStatus.OK) {
                    direction.setDirections(response);
                    var recap="Distance: "+Math.ceil(response.routes[0].legs[0].distance.value/1000)+" km</br>"
                    +"Durée: "+Math.floor(response.routes[0].legs[0].duration.value/3600)+" h "+Math.ceil((response.routes[0].legs[0].duration.value%3600)/60)+" min";
                    $('#recapitulatif').html(recap);
                    
                }
            });
    } //http://code.google.com/intl/fr-FR/apis/maps/documentation/javascript/reference.html#DirectionsRequest
};
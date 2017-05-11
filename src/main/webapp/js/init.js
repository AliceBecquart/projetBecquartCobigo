$(document).ready(function () {


    //Changement de forme du nav
    $(".button-collapse").sideNav();

    //Bouton dropdown
    $(".dropdown-button").dropdown();

    //Paramètres du Modal
    $('.modal-trigger').leanModal({
        dismissible: true, // Modal can be dismissed by clicking outside of the modal
        opacity: .5, // Opacity of modal background
        in_duration: 300, // Transition in duration
        out_duration: 200 // Transition out duration

    });


    //Calendrier
    $('#calendar').fullCalendar({
        height: '350',
        default: false,
        editable: false,
        lang: 'fr',
        defaultView: 'agendaWeek',
        color: 'grey lighten-4',     // an option!


        //Mise en forme du header
        header: {
            prev: 'circle-triangle-w',
            next: 'circle-triangle-e',
            left: 'prev,next today',
            center: 'title',
            right: 'agendaWeek,agendaDay',
        },


        //Ouverture modal après clic
        eventClick: function (event) {
            console.log("eventClick: function (event)"),
                $('#modalTitle').html(event.title);
            $('#modalBody').html('Lieu : ' + event.lieu + '<br/><br/> Description : ' + event.description);
            $('#eventUrl').attr('href', event.url);
            $('#modal1').openModal();
        }

        ,

        //Ajouter lieu sur l'événement
        eventRender: function (event, element, view) {
            element.find('.fc-title').append("<br/>" + event.lieu);
        }
    })
    ;
})
;


evenements.forEach(function (evenement) {
    console.log(evenement);
    {
        title: evenement.evenement_nom;
        start: evenement.evenement_date_debutTevenement.evenement_heure_debutZ;
        end: evenement.evenement_date_finTevenement.evenement_heure_finZ;
    }


});




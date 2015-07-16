/**
 * Created by katsiaryna.siamikina on 15.07.2015.
 */
var PlacesView = Backbone.View.extend({

    el: Application.constants.PLACE_PICKER_SELECTOR,

    events : {
        "click .placeItem" : "toggleItem"
    },

    render: function (placeType, stockId) {

        this.places = new Places();
        this.places.setParameters(placeType, stockId);

        var options = {
            error: function (data) {
                console.log(JSON.stringify(data));
            },
            success: function (data) {
                console.log(JSON.stringify(data));
            }
        };

        var instance = this;
        this.places.fetch(options)
            .always(function (data) {
                Util.renderView(
                    instance,
                    "modal-place-picker",
                    "resources/app/js/waybill/template/",
                    ".html",
                    data,
                    "places"
                );
            });
    },

    toggleItem : function(event) {

        var placeId = $(event.currentTarget).data('place-id');
        console.log("place toggled is " + placeId );
    }
});
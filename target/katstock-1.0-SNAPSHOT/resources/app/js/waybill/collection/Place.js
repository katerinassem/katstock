/**
 * Created by katsiaryna.siamikina on 15.07.2015.
 */
var Place = Backbone.Model.extend( {

    url : function() {
        return "place/" + this.get("placeId");
    },

    idAttribute : function() {
        return "placeId";
    }

});
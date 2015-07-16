/**
 * Created by katsiaryna.siamikina on 15.07.2015.
 */
var Places = Backbone.Collection.extend( {

    model : Place,

    modelId : function() {
        return "placeId";
    },

    url : function() {
        return "places/" + this.placeType + "/" + this.stockId;
    },

    setParameters : function(placeType, stockId) {

         this.placeType = placeType;
         this.stockId = stockId;
    }

});
/**
 * Created by katsiaryna.siamikina on 10.07.2015.
 */
var Stock = Backbone.Model.extend( {

    idAttribute : function(attributes) {
        return "stockId";
    },

    url : function () {
        return "stock/" + this.get("stockId");
    }
});
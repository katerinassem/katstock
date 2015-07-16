/**
 * Created by katsiaryna.siamikina on 14.07.2015.
 */
var WaybillView = Backbone.View.extend( {

    el : Application.constants.PARTIAL_VIEW_SELECTOR,

    events : {
        "click #add-stock-item" : "addStockItem",
        "click .choose-place-button" : "renderPlacePicker",
        "click .place-item.available-true" : "choosePlace"
    },

    render : function(id) {

        this.stockId = id;
        this.stockItemIndex = 0;

        var instance = this;
        Util.renderView(
            instance,
            "waybill",
            "resources/app/js/waybill/template/",
            ".html",
            {},
            undefined,
            function() {
                instance.renderStockItem();
            }
        );
    },

    addStockItem : function() {

        //render goods
        this.renderStockItem();
    },

    renderStockItem : function() {

        Util.renderViewAfter(
            this,
            "stock-item",
            "resources/app/js/waybill/template/",
            ".html",
            {
                index : this.stockItemIndex++
            },
            "stockItem"
        );
    },

    renderPlacePicker : function(event) {
        var placeTypeSelect = $($(event.currentTarget).data('place-type-select-selector'))[0];
        if(placeTypeSelect) {
            var placeType = placeTypeSelect.options[placeTypeSelect.selectedIndex].text;
            console.log(placeType);

            ViewsFactory.placePicker().render(placeType, this.stockId);
        }
    },

    choosePlace : function(event) {
        var placeId = $(event.currentTarget).data('place-id');
        console.log("reserved place " + placeId);
        $(event.currentTarget).removeClass("available-true").addClass("available-reserved");
    }
});
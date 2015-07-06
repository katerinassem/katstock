/**
 * Created by katsiaryna.siamikina on 06.07.2015.
 */
var Click = Backbone.View.extend({

    el: $("#partial-view"),
    template : _.template($("#bookTemplate").html()),

    render : function() {
        this.$el.html(this.template({name : "Kate"}));
        return this;
    },

    events : {
        'click .title': 'onTitleClick'
    },

    'onTitleClick' : function(event) {
        alert('Клик');
    }
});

var click = new Click();
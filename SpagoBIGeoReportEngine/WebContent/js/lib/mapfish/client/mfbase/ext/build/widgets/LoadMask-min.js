Ext.LoadMask=function(c,b){this.el=Ext.get(c);Ext.apply(this,b);if(this.store){this.store.on("beforeload",this.onBeforeLoad,this);this.store.on("load",this.onLoad,this);this.store.on("loadexception",this.onLoad,this);this.removeMask=Ext.value(this.removeMask,false)}else{var a=this.el.getUpdater();a.showLoadIndicator=false;a.on("beforeupdate",this.onBeforeLoad,this);a.on("update",this.onLoad,this);a.on("failure",this.onLoad,this);this.removeMask=Ext.value(this.removeMask,true)}};Ext.LoadMask.prototype={msg:"Loading...",msgCls:"x-mask-loading",disabled:false,disable:function(){this.disabled=true},enable:function(){this.disabled=false},onLoad:function(){this.el.unmask(this.removeMask)},onBeforeLoad:function(){if(!this.disabled){this.el.mask(this.msg,this.msgCls)}},show:function(){this.onBeforeLoad()},hide:function(){this.onLoad()},destroy:function(){if(this.store){this.store.un("beforeload",this.onBeforeLoad,this);this.store.un("load",this.onLoad,this);this.store.un("loadexception",this.onLoad,this)}else{var a=this.el.getUpdater();a.un("beforeupdate",this.onBeforeLoad,this);a.un("update",this.onLoad,this);a.un("failure",this.onLoad,this)}}};
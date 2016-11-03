// TODO: may need to change this regex later on.
var context = require.context('./src/app', true, /.+\.spec\.jsx?$/i);
context.keys().forEach(context);
var context = require.context('./src/app', true, /.+\.spec\.jsx?$/i);
context.keys().forEach(context);
var HtmlWebpackPlugin = require('html-webpack-plugin');
var ExtractTextPlugin = require('extract-text-webpack-plugin');
var webpack = require('webpack');
var path = require('path');

module.exports = {
	// Entry file to bundle + children/dependencies
	entry: path.join(__dirname, '/src/app/main.jsx'),
	
	// Output bundle as
	output: {
		path: './build',
		filename: 'bundle.js'
	},
	
	//all these extensions will be resolved without specifying extension in the `require` function
	resolve: {
		extensions: [ '', '.js', '.jsx' ]
	},
	// Serve files from build directory, inline (vs. iframe), and port 8080
	devServer: {
		contentBase: path.join(__dirname, '/build'),
		inline: true,
		port: 8080,
		open: true
	},
	
	// For all files that pass test:, run through specified loader and transpile/compile to output path
	module: {
		loaders: [
			{
				test: /\.jsx?$/, 
				exclude: /(node_modules|bower_components)/, 
				loader: 'babel', 
				query: { 
					presets: ['es2015', 'react', 'stage-0'] 
				} 
			},
			{
				test: /\.scss$/,
				loader: ExtractTextPlugin.extract('css!sass')
			}
		]
	},
	
	// Plugins used by loaders or standalone 
	plugins: [
        new ExtractTextPlugin('css/styles.css', {
			allChunks: true
		}),
		
		new HtmlWebpackPlugin({
			filename: 'index.html',
			template: path.join(__dirname, '/src/index.html')
		})
    ]
};
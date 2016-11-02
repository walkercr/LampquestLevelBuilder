// Karma configuration
// Generated on Mon Jul 18 2016 21:51:54 GMT-0500 (Central Daylight Time)

module.exports = function(config) {
  config.set({

    // base path that will be used to resolve all patterns (eg. files, exclude)
    basePath: '',


    // frameworks to use
    // available frameworks: https://npmjs.org/browse/keyword/karma-adapter
    frameworks: ['mocha', 'chai'],


    // list of files / patterns to load in the browser
    files: [
      'tests.bundle.js'
    ],
	
	plugins: [
		'karma-chrome-launcher', 
		'karma-phantomjs-launcher', 
		'karma-chai', 
		'karma-mocha',
		'karma-sourcemap-loader',
		'karma-webpack',
		'karma-coverage',
		'karma-mocha-reporter'
    ],
	
    // list of files to exclude
    exclude: [],

    // preprocess matching files before serving them to the browser
    // available preprocessors: https://npmjs.org/browse/keyword/karma-preprocessor
    preprocessors: {
		// we don't need the coverage preprocessor because we're instrumenting the files with webpack
		'tests.bundle.js': ['webpack', 'sourcemap']
	},
	
	//kind of a copy of your webpack config
	webpack: {
		devtool: 'inline-source-map', //just do inline source maps instead of the default
		module: {
			loaders: [
				{
					test: /\.jsx?$/, 
					exclude: /(node_modules|bower_components)/, 
					loader: 'babel', 
					query: { 
						presets: ['es2015', 'react', 'stage-0'] 
					}
				}
			],
			
			//delays coverage til after tests are run, fixing transpiled source coverage error
			postLoaders: [
				{
					test: /\.jsx?$/, 
					exclude: /(node_modules|bower_components)/, 
					loader: 'istanbul-instrumenter'
				}
			]
		}
	},
	
	// silence all middleware console output from webpack
	webpackMiddleware: {
		noInfo: true
	},
	
    // test results reporter to use
    // possible values: 'dots', 'progress', 'mocha'
    // available reporters: https://npmjs.org/browse/keyword/karma-reporter
    reporters: ['progress', 'coverage', 'mocha'],

	// Display coverage report as html file in coverage/ folder
	coverageReporter: {
		type: 'html',
		dir: 'coverage/'
	},

    // web server port
    port: 9876,


    // enable / disable colors in the output (reporters and logs)
    colors: true,


    // level of logging
    // possible values: config.LOG_DISABLE || config.LOG_ERROR || config.LOG_WARN || config.LOG_INFO || config.LOG_DEBUG
    logLevel: config.LOG_INFO,


    // enable / disable watching file and executing tests whenever any file changes
    autoWatch: true,


    // start these browsers
    // available browser launchers: https://npmjs.org/browse/keyword/karma-launcher
    browsers: ['PhantomJS', 'Chrome'],


    // Continuous Integration mode
    // if true, Karma captures browsers, runs the tests and exits
    singleRun: false,

    // Concurrency level
    // how many browser should be started simultaneous
    concurrency: Infinity
  })
}

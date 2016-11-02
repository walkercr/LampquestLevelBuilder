# react-webpack-template
React.js + webpack + babel + karma + mocha 

If you're anything like me, you may have found it hard to begin familiarizing yourself with React, especially when considering all the different templates and starter kits out there. One thing I found particularly confusing was that each template/guide I looked at had an endless list of dependencies with essentially no explanation of their purpose. For this reason my goal was to produce a sort of semi-minimalist setup and allow for extra dependencies to be added if desired. Below you can find a list of all the dependencies as well as a brief explanation of what does (hope this helps someone out there!).

# ---- How To Run ----

**_npm run start_**

> webpack-dev-server -d --progress --colors --display-error-details --display-reasons
	
**_npm run build_**

> webpack -d --progress --colors --display-error-details --display-reasons

**_npm run test_**

> karma start

**_npm run clean_**

> rimraf ./build
	
**_npm run clean:nm_**

> rimraf ./node_modules
	
**_npm clean:all_**

> npm run clean & npm run clean:nm & rimraf ./coverage

	
# ---- Dependencies ----

__react:__ 

> React.js library.


__react-dom:__ 

> React.js server-side dom renderer.


# ---- Dev Dependencies ----

__babel-core:__

> Core library for transpiling Javascript.


__babel-loader:__ 

> This package allows us to use JSX and ES6; loads . jsx? & transpiles to specified version.


__babel-preset-es2015:__ 

> This preset is used to tell babel-loader to interpret/transpile es2015 (ES6).


__babel-preset-react:__ 

> This preset allows babel-loader to interpret react's .jsx files.


__babel-preset-stage-0:__ 

> Enables some es7 features and all below.


__css-loader, node-sass, sass-loader:__

> All 3 of these used to compile sass to css 


__extract-text-webpack-plugin:__ 

> Used to extract compiled css into a standalone, physical .css file.


__html-webpack-plugin:__ 

> Used to generate index.html file for builds.


__rimraf:__ 

> Used for universal OS remove command for clean task.


__webpack:__ 

> Webpack bundler. Used as the primary js file bundler.


__webpack-dev-server:__ 

> Small express server with hot deploy/reload.


__karma-cli:__ 

> Required so karma may use cli commands when we test.


__phantomJS:__ 

> So we can run karma tests w/o browser.


__karma-coverage:__ 

> To generate code coverage report.


__istanbul-instrumenter-loader:__ 

> Fixes the issue with karma-coverage returning transpiled source code.


__mocha:__ 

> The mocha libary test framework.


__karma-mocha:__ 

> Required in order to use the mocha test framework with Karma.


__chai:__ 

> The chai assertion library we're using in mocha.


__karma-chai:__ 

> Required to use chai with karma (include as framework in karma.frameworks).


__sinon:__ 

> Standalone test spies, stubs and mocks for our tests to go with chai.


__karma-sinon:__ 

> Required to use sinon with karma (include as framework in karma.frameworks).


__karma-webpack:__ 

> Allows karma to work with webpack for pre/post-processing; To get non-transpiled code from our test coverage tool.


__karma-sourcemap-loader:__ 

> Maps console output/debugging to original, non-compiled source files for sensible debugging.


__karma-chrome-launcher:__ 

> Allows you to use the (Chrome) debugger in the browser while testing; runs tests literally through Chrome.

const path = require('path');
const webpack = require('webpack');
const merge = require('webpack-merge');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const NpmInstallPlugin = require('npm-install-webpack-plugin');

const TARGET = process.env.npm_lifecycle_event;
const PATHS = {
    app: path.join(__dirname, 'app'),
    build: path.join(__dirname, 'build')
};

const common = {
    //Entry accepts a path or an object of entries.
    //We'll be using the latter form given it's
    //convenient with more complex configurations.
    entry: {
        app: PATHS.app
    },
    output: {
        path: PATHS.build,
        filename: 'bundle.js'
    },
    plugins: [
        new HtmlWebpackPlugin({
            title: 'Webpack demo'
        })
    ],
    module: {
        loaders: [
            {
                // Test expects a RegExp! Note the slashes!
                test: /\.css$/,
                loaders: ['style', 'css'],
                // Include accepts either a path or an array of paths.
                include: PATHS.app
            }
        ]
    }
};

// Default configuration.  We will return this if
// Webpack is called outside of npm.

if (TARGET === 'start' || !TARGET) {
    module.exports = merge(common, {                    
        devtool: 'eval-source-map',
        devServer: {
            // Enable history API fallback so HTML5 History API based
            // routing works.  This is a good default that will come in
            // handy in more complicated setups.
            historyApiFallback: true,
            hot: true,
            inline: true,
            progress: true,
            
            // Display only errors to reduce the amount of output.
            stats: 'errors-only',
            
            // Parse host and port from env to allow customization.
            //
            // If you use Vagrant or Cloud9, set
            // host: process.env.HOST || '0.0.0.0';
            //
            // 0.0.0.0 is available to all network devices
            // unlike default localhost
            host: process.env.HOST,
            port: process.env.port
            
            // If you want defaults, you can use a little trick like this
            // port: process.env.PORT || 3000
        },
        plugins: [
            new webpack.HotModuleReplacementPlugin(),
            new NpmInstallPlugin({
                save: true  //equivalent to --save command line argument
            })
        ]
    });
}

if (TARGET === 'build') {
    module.exports = merge(common, {
        plugins: [
            // Setting DefinePlugin affects React library size!
            // DefinePlugin replaces content "as is" so we need some
            // extra quotes for the generated code to make sense
            new webpack.DefinePlugin({
                'process.env.NODE_ENV': '"production"'
               // You can set this to '"development"' or JSON.stringify('development')
               // for your development target to force NODE_ENV to development mode
               // no matter what.
            }),
            new webpack.optimize.UglifyJsPlugin({
                compress: {
                    warnings: false
                }
            })
        ]
    });
}
const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin'); //installed via npm
const webpack = require('webpack'); //to access built-in plugins

const config = {
  entry: './src/app.js',
  output: {
    path: path.resolve(__dirname, 'dist'),
    filename: 'bundle.js'
  },
  module: {
    rules: [
      //{test: /\.txt$/, use: 'raw-loader'}
      {
        test: [/\.js$/],
        exclude: /node_modules/,
        use: {
          loader: 'babel-loader',
          options: {
            presets: [
              ["env", {
                "targets": {
                  "browsers": ["last 2 Chrome versions"]
                }
              }]
            ]
          }
        }
      }
    ]
  },
  plugins: [
    new webpack.optimize.UglifyJsPlugin(),
    new HtmlWebpackPlugin({template: './index.html'})
  ],
  devServer: {
    port: 4001
  },
  devtool: 'inline-source-map'
};

module.exports = config;
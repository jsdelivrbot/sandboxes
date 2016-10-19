import React from 'react';
import ReactDOM from 'react-dom';
import Board from './Board';
import { observe } from './Game';

const rootEl = document.getElementById('root');

observe(knightPosition => {
    console.log('observe called: knightPosition = ' + knightPosition);
    ReactDOM.render(
      <Board knightPosition={knightPosition}/>,
      rootEl
    )
  }
);

ReactDOM.render(
  <Board knightPosition={[1, 7]} />,
  document.getElementById('root')
);

import React from 'react';
import ReactDOM from 'react-dom';
import Board from './Board';
import { observe } from './Game';

const rootEl = document.getElementById('root');

observe(knightPosition => {
  ReactDOM.render(
    <div style={{
      width: 500,
      eight: 500,
      border: '1px solid gray'
    }}>
      <Board knightPosition={knightPosition} />
    </div>,
    rootEl
  );
  }
);

ReactDOM.render(
  <div style={{
      width: 500,
      eight: 500,
      border: '1px solid gray'
      }}>
      <Board knightPosition={[1,7]} />
    </div>,
  rootEl
);

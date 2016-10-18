import React from 'react';
import { storiesOf, action, linkTo } from '@kadira/storybook';
import Button from './Button';
import Welcome from './Welcome';
import Knight from './../src/Knight';
import Square from './../src/Square';
import Board from './../src/Board';

storiesOf('Welcome', module)
  .add('to Storybook', () => (
    <Welcome showApp={linkTo('Button')}/>
  ));

storiesOf('Button', module)
  .add('with text', () => (
    <Button onClick={action('clicked')}>Hello Button</Button>
  ))
  .add('with some emoji', () => (
    <Button onClick={action('clicked')}>😀 😎 👍 💯</Button>
  )
);

storiesOf('Square', module).
  add('Basic Knight', () => (
    <Knight />
  ))
  .add('Black Square w/ Knight', () => (
    <Square black>
      <Knight />
    </Square>
  ))
  .add('White Square w/ Knight', () => (
    <Square>
      <Knight />
    </Square>
  ))
  .add('Empty black square', () => (
    <Square black>
    </Square>
  )
);

storiesOf('Chessboard', module).
  add('Simple Board', () => (
    <Board knightPosition={[0, 0]} />
  )
);

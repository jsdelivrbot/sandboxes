import { renderComponent, expect} from '../test_helper';
import CommentBox from '../../src/components/comment_box';

describe('CommentBox', () => {
  let component;
  beforeEach(() => {
    component = renderComponent(CommentBox);
  });
  it('has class comment-box', () => {
    expect(component).to.have.class('comment-box');
  });
  it('has a text area', () => {
    expect(component.find('textarea')).to.exist;
  });
  it('has a button', () => {
    expect(component.find('button')).to.exist;
  });

  describe('entering some text', () => {
    const newCommentValue = 'new comment value';
    beforeEach(() => {
      component.find('textarea').simulate('change', newCommentValue);
    });
    it('shows text that is entered', () => {
      expect(component.find('textarea')).to.have.value(newCommentValue);
    });

    it('when submitted, clears the input', () => {
      console.log(component);
      component.simulate('submit');
      expect(component.find('textarea')).to.have.value('');
    });
  });
});
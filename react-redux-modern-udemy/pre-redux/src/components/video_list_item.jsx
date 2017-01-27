import React from 'react';

const VideoListItem = ({video, onVideoSelect}) => {
  //Note: the {video} parameter shortcut above is equivalent to
  //declaring the following commented out line:
  //const video = props.video;

  const imageUrl = video.snippet.thumbnails.default.url;

  return (
    <li onClick={() => onVideoSelect(video)} className="list-group-item">
      <div className="video-list media">
        <div className="media-left">
          <img className="media-object" src={imageUrl} />
        </div>

        <div className="media-body">
          <div className="media-heading">{video.snippet.title}</div>
        </div>
      </div>
    </li>
  );
};

VideoListItem.propTypes = {
  video: React.PropTypes.object
};

export default VideoListItem;
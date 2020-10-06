import React, {Component} from 'react';
import axios from 'axios';
// For our data fetching exercise we're gonna take advantage of the Notes REST API that you already created.
//
// It is best to use lifecycle method `componentDidMount` to
// make AJAX requests. This method will be called once before the component
// is inserted into the document, regardless of how many times `render` is
// called.
//
// Exercise:
//
//  Create a NotesGrid component that lists all the notes from http://localhost:8080/api/notes.
//  This component needs to display all the notes in a grid with their info as "title", "content", "tags".
//

export default class NotesGrid extends Component {

    state = {
        posts: {}
    };

    componentDidMount() {
        axios.get('/api/notes')
            .then(response => {
                this.setState({
                    posts: response.data
                });
            });
    }

    render() {
        return (
            <div>
                {Object.keys(this.state.posts).map(key =>
                    <Note key={this.state.posts[key].id} post={this.state.posts[key]}/>
                )}
            </div>
        );
    }
}

function Note({post: {title, content, tags}}) {
    return (
        <div className="note">
            <div className="note-header">{title}</div>
            <div className="note-content">{content}</div>
            <div className="note-footer">
                {Object.keys(tags).map(key =>
                    <span key={tags[key].id}> #{tags[key].name} </span>
                )}
            </div>
        </div>
    );
}

export const Example = () => <NotesGrid/>;

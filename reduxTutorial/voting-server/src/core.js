import {List, Map} from 'immutable';

export const INITIAL_STATE = Map();

export function setEntries(state, entries) {
	return state.set('entries', List(entries));
}

function getWinners(vote) {
	if (!vote) {
		return [];
	}
	const [a, b] = vote.get('pair');
	const aVotes = vote.getIn(['tally', a], 0);
	const bVotes = vote.getIn(['tally', b], 0);
	if (aVotes > bVotes) {
				console.log('Returning a');
		return [a];
	} else if (aVotes < bVotes) {
				console.log('Returning b');
		return [b];
	} else {
		console.log('Returning both');
		return [a, b];
	}
}

/*
Determines the current winner based on the tally, sends the winning item to the 
end of the entries list and loads the first two entries in the list to be voted next.
*/
export function next(state) {
	const entries = state.get('entries').
		concat(getWinners(state.get('vote')));
	if (entries.size === 1) {
		return state.remove('vote')
			.remove('entries')
			.set('winner', entries.first());
	} else {
		return state.merge({
			vote: Map({pair: entries.take(2)}),
			entries: entries.skip(2)
		});
	}
}

export function vote(voteState, entry) {
	return voteState.updateIn(
		['tally', entry],
		0,
		tally => tally + 1
	);
}
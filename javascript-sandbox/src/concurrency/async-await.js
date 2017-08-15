import Api from './example-api';

export default async function asyncAwaitExample() {
  console.log('asyncAwaitExample running!');
  const api = new Api();
  const user = await api.getUser();
  const friends = await api.getFriends(user.id);
  const photo = await api.getPhoto(user.id);
  console.log('asyncAwaitExample completed!', { user, friends, photo });
}
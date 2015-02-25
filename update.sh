_DATE=$(date +%Y.%d.%m-%H.%M.%S)
_DIR=$(dirname $(readlink -f $0))

cd $_DIR
# echo "sauvegarde des modifications depuis la dernière fois"
# git checkout -b stage-$_DATE
# git commit -am "sauvegarde du $_DATE"
# git checkout master

echo "récupère les mises à jour depuis l'internet"
git pull

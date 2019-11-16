## 概要
今回作業を行った環境は以下の通りである。
よって、この環境でのDB環境のインストールから接続までを記す。
- OS: Windows 10 Pro
- IDE: Eclipse

## インストール・ダウンロード
### PostgreSQL
[こちら]( https://www.enterprisedb.com/downloads/postgres-postgresql-downloads)のページからインストーラをダウンロードする。  
今回は、バージョン11系を使用した。
ダウンロードしたexeファイルを実行し、指示に従ってNextを押す。  
基本デフォルトでよい。
パスワードの設定は、今回は`postgres`とした。  
`postgres`以外にしたければ、DodgeWallプロジェクトの`src/process/Ranking.java`を編集する。  
インストールが完了した後のチェックボックスは外してFinishを押して終了する。
インストールが完了したら環境変数を設定して完了である。
Pathはバージョン11系の場合、`C:\Program Files\PostgreSQL\11\bin`を通せばよい。

### JDBC
[こちら](https://jdbc.postgresql.org/download.html)のページからJDBCをダウンロードする。  
バージョンはJavaのバージョンを確認してダウンロードを行う。
今回はJava 11を使用したため、4.2系をダウンロードした。


## データベースとテーブルの作成
コンソールを起動し、以下のコマンドを入力しデータベースに接続する。
```
$ psql -U postgres
```
ここで、パスワードの入力を求められるので設定したパスワードを入力する。  
その後、今回使用するDodgeWallというデータベースを作成する。
```
# create database dodge_wall;
```
そして、作成したデータベースに接続する。
```
# \c dodge_wall
```
接続したデータベース内でテーブルを作成する。
```
# create table ranking (id serial primary key, name text, score integer);
```
これでデータベースとテーブルの作成は完了である。

## Eclipseでの設定
Eclipseを開いて、DodgeWallプロジェクトを選択して右クリックする。  
`ビルドパス->外部アーカイブの追加`を選択し、先にダウンロードしたJDBCのjarファイルを選択する。